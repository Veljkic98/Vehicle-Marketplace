package marketplace.backend.dto.requestDTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class AuthenticatedUserRequestDTO {
    
    @NotBlank(message = "First name cannot be blank")
    private String firstName;

    @NotBlank(message = "Last name cannot be blank")
    private String lastName;

    @Email(message = "Email must be valid email address")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    private String password;

    @NotBlank(message = "Company name (username) cannot be blank")
    private String companyName;


    public AuthenticatedUserRequestDTO() {
    }

    public AuthenticatedUserRequestDTO(String firstName, String lastName, String email, String password, String companyName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.companyName = companyName;
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

    public String getCompanyName() {
        return this.companyName;
    }

}
