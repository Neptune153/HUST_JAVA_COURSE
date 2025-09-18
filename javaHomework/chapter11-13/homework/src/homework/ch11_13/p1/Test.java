package homework.ch11_13.p1;



public class Test {
    public static void main(String[] args) {
        // 创建任务服务
        TaskService taskService = new TaskServiceImpl();

        // 添加任务
        taskService.addTask(new Task1());
        taskService.addTask(new Task2());
        taskService.addTask(new Task3());

        // 执行任务
        taskService.exeuteTasks();
    }
}
// 任务1
class Task1 implements Task {
    @Override
    public void execute() {
        System.out.println("Task 1 is executed");
    }
}

class Task2 implements Task {
    @Override
    public void execute() {
        System.out.println("Task 2 is executed");
    }
}
class Task3 implements Task {
    @Override
    public void execute() {
        System.out.println("Task 3 is executed");
    }
}
