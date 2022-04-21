package oct.rekord.boot.bean;



/**
 * 宠物
 */

public class Pet {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pet() {

    }
    public Pet(String name) {
        this.name = name;
    }
}
