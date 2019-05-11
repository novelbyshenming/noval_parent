package bean;

/**
 * @author LX
 * @date 2019/5/1 - 18:24
 */
public class User {

    private long uid;

    private String name;

    private String pwd;

    private double money;

    private String tel;

    private String email;

    private int age;
    
    private String sex;
    
    private String head;

    public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    /*@Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", money=" + money +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }*/

    
    public int getAge() {
        return age;
    }

    @Override
	public String toString() {
		return "User [uid=" + uid + ", name=" + name + ", pwd=" + pwd + ", money=" + money + ", tel=" + tel + ", email="
				+ email + ", age=" + age + ", sex=" + sex + ", head=" + head + "]";
	}

	public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }


}
