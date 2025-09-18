package homework.ch11_13.p1;


import java.util.ArrayList;

public class TaskServiceImpl implements TaskService {
   private final ArrayList<Task> tasks;

    TaskServiceImpl(){
        tasks = new ArrayList<>();
    }
    /**
     * 执行任务接口列表中的每个任务
     */
    @Override
    public void exeuteTasks() {
        for(Task t : tasks){
            t.execute();
        }
    }

    /**
     * 添加任务
     * @param t 新添加的任务
     */
    @Override
    public void addTask(Task t) {
        tasks.add(t);
    }

}
