package entity;

import util.Constants;

public class User extends Entity{
    private String name;
    private String password;
    private String email;
    private String useraccount;
    
    private int    id;
    
    private int    type;
    private String typeCN;
   
    private int state;
    private String stateCN;
   


    public String getUseraccount() {
        return useraccount;
    }

    public void setUseraccount(String useraccount) {
        this.useraccount = useraccount;
    }

    public User() {
    }

    public User(String n, String p, String e, int type) {
        this.name = n;
        this.password = p;
        this.email = e;
        this.type = type;
        this.state = Constants.int_active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
        setTypeCN();
    }
    
    public void setTypeCN() {
        switch (type) {
            case Constants.int_sysAdmin:
            	typeCN = Constants.sysAdmin;
                break;
            case Constants.int_depotAdmin:
            	typeCN = Constants.depotAdmin;
                break;
            case Constants.int_borrAdmin:
            	typeCN = Constants.borrAdmin;
                break;
            case Constants.int_reader:
            	typeCN = Constants.reader;
                break;
            default:
            	typeCN = Constants.unknown;
                break;
        }
    }
    
    
    public String getTypeCN() {
        return typeCN;
    }
    
    public void setState(int s) {
       this.state = s;
       setStateCN();
    }
    
    public int getState() {
        return this.state;
    }

    public void setStateCN() {
    	 switch (this.state) {
         case Constants.int_lock:
             this.stateCN = Constants.lock;
             break;
         default:
        	 this.stateCN = Constants.active;
             break;
     }
    }
    
    public String getStateCN() {
        return this.stateCN;
    }
    

    
}
