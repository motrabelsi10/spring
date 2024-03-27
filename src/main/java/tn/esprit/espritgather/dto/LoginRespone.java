package tn.esprit.espritgather.dto;

public class LoginRespone {
    private  String jwtToken;

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public LoginRespone(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
