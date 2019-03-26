package cn.fhypayaso.bodyIndex.business.login.modal.request;

public class LoginRequestModal {

    /**
     * account : 13081856666
     * password : 123456
     */

    private String account;
    private String password;

    public LoginRequestModal(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
