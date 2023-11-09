package SpringBoot.EmployeeBook.Services;

import SpringBoot.EmployeeBook.Dto.TaskDTO;
import SpringBoot.EmployeeBook.Entity.Employee;
import SpringBoot.EmployeeBook.Entity.Task;
import SpringBoot.EmployeeBook.Exception.APIException;
import SpringBoot.EmployeeBook.Repository.EmployeeRepository;
import SpringBoot.EmployeeBook.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    public Task addTask(TaskDTO taskDTO) {
        // Retrieve the Employee entity based on the provided employeeId
        Employee employee = employeeRepository.findById(taskDTO.getEmployeeId())
                .orElseThrow(() -> new APIException("Employee not found."));

        Task task = new Task();
        task.setTaskName(taskDTO.getTaskName());
        task.setEmployee(employee);

        return taskRepository.save(task);
    }

    public Task getTask(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new APIException("Task not found."));
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task updateTask(Long id, TaskDTO taskDTO) {
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new APIException("Task not found.")); // 404 for Not Found


        // Retrieve the Employee entity based on the provided employeeId
        Employee employee = employeeRepository.findById(taskDTO.getEmployeeId())
                .orElseThrow(() -> new APIException("Employee not found."));

        existingTask.setTaskName(taskDTO.getTaskName());
        existingTask.setEmployee(employee);

        return taskRepository.save(existingTask);
    }

    public boolean deleteTask(Long id) {
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new APIException("Task not found."));

        taskRepository.delete(existingTask);
        return true;
    }
}
