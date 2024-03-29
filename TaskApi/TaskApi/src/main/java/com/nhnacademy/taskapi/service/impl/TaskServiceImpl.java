package com.nhnacademy.taskapi.service.impl;

import com.nhnacademy.taskapi.entity.Tasks;
import com.nhnacademy.taskapi.repository.MilestoneRepository;
import com.nhnacademy.taskapi.repository.ProjectRepository;
import com.nhnacademy.taskapi.repository.TaskRepository;
import com.nhnacademy.taskapi.request.TaskRequest;
import com.nhnacademy.taskapi.response.TaskResponse;
import com.nhnacademy.taskapi.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;
    private final MilestoneRepository milestoneRepository;



    @Override
    @Transactional
    public void createTask(TaskRequest request) {
        Tasks tasks = Tasks.builder()
                .taskName(request.getTaskName())
                .taskContent(request.getTaskContent())
                .taskWriter(request.getTaskWriter())
                .project(projectRepository.findById(request.getProjectNum()).get())
                .milestoneNum(milestoneRepository.findById(request.getMilestoneNum()).get())
                .chargePerson(request.getChargePerson())
                .build();
        taskRepository.save(tasks);
    }

    @Override
    @Transactional
    public void modifyTask(TaskRequest taskRequest) {
        Optional<Tasks> task = taskRepository.findById(taskRequest.getTaskNum());
        task.get().setTaskContent(taskRequest.getTaskContent());
        task.get().setTaskName(taskRequest.getTaskName());
        taskRepository.save(task.get());
    }

    @Override
    public void deleteTask(Long taskNum) {
        projectRepository.deleteById(taskNum);
    }

    @Override
    public List<TaskResponse> findTaskList(Long projectNum) {
        List<Tasks> tasksList = taskRepository.findByProject_ProjectNum(projectNum);
        return tasksList.stream().map(tasks -> new TaskResponse(tasks)).collect(Collectors.toList());
    }

    @Override
    public TaskResponse findTask(Long taskNum) {
        Optional<Tasks> tasks = taskRepository.findById(taskNum);
        return new TaskResponse(tasks.get());
    }


}
