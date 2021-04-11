package marketplace.backend.dto.requestDTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class AdminRequestDTO {

    @NotBlank(message = "First name cannot be blank")
    private String firstName;

    @NotBlank(message = "Last name cannot be blank")
    private String lastName;

    @Email(message = "Email must be valid email address")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    private String password;

    public AdminRequestDTO() {
    }

    public AdminRequestDTO(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

}
