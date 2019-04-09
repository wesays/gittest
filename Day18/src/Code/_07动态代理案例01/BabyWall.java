package Code._07动态代理案例01;

public class BabyWall implements Star{
    @Override
    public void sing(String name) {
        System.out.println("枪哥唱首歌");
    }

    @Override
    public void dance() {
        System.out.println("枪哥跳个舞");
    }
}
