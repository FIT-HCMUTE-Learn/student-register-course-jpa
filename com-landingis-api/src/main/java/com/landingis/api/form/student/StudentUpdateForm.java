package com.landingis.api.form.student;

import com.landingis.api.validation.GenderConstraint;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentUpdateForm {

    @ApiModelProperty(value = "Student id", example = "1", required = true)
    @NotNull(message = "Student id cannot be null")
    private Long studentId;

    @ApiModelProperty(value = "User handle (username)", example = "johndoe", required = true)
    @NotEmpty(message = "User handle cannot be empty")
    private String userHandle;

    @ApiModelProperty(value = "User password", example = "Secure@123", required = true)
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*\\W).{6,}$",
            message = "Password must have at least 6 characters, 1 uppercase letter, and 1 special character"
    )
    private String userPassword;

    @ApiModelProperty(value = "User full name", example = "John Doe", required = true)
    @NotEmpty(message = "User full name cannot be empty")
    private String userFullName;

    @ApiModelProperty(value = "Gender (1: Male, 2: Female, 3: Other)", example = "1", required = false)
    @GenderConstraint(allowNull = true)
    private Integer userGender;

    @ApiModelProperty(value = "Student code", example = "STU25110799", required = true)
    @NotEmpty(message = "Student code cannot be empty")
    private String studentCode;

    @ApiModelProperty(value = "Student birthday (must be in the past)", example = "2000-01-15", required = true)
    @Past(message = "Student birthday must be in the past")
    private Date studentBirthday;
}
