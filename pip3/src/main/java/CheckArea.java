import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.util.List;
public class CheckArea implements java.io.Serializable {
    Double x;
    Double y;
    Double r;
    DataBase dataBase;
    public CheckArea(){
        dataBase = new DataBase();
    }
    public void setX(Double x){
        this.x=x;
    }
    public void setY(Double y){
        this.y=y;
    }
    public void setR(Double r){
        this.r=r;
    }
    public Double getX(){
        return x;
    }
    public Double getY(){
        return y;
    }
    public Double getR(){
        return r;
    }
    public String check()
    {
        if((y<=-x+r&&y>=0&&x>=0)||(y<=0&&y>=-r&&x>=0&&x<=r/2)||(x*x+y*y<=(r/2)*(r/2)&&x<=0&&y<=0))
            return "in the area";
        return "not in the area";
    }
    public String addToDb(){
        String res = check();
        dataBase.add(x,y,r,res);
        return "add";
    }
    public List getResponse(){
        List response;
        response = dataBase.getAll();
        return response;
    }
    public void clear(){
        dataBase.clear();
    }

}
