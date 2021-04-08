package cn.html;

public enum XMLEnum {
    AUTOMATIC_STYLE("automatic-styles"),
    STYLE_NAME("name");


    private final String status;
    XMLEnum( String status) {
        this.status = status;
    }
    public  String getValue(){
        return this.status;
    }
}
