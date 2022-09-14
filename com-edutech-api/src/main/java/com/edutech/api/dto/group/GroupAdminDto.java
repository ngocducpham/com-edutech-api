package com.edutech.api.dto.group;

import java.util.List;

import com.edutech.api.dto.ABasicAdminDto;
import com.edutech.api.dto.permission.PermissionDto;

//import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class GroupAdminDto extends ABasicAdminDto {

    @Schema(name = "name")
    private String name;
    @Schema(name = "description")
    private String description;
    @Schema(name = "kind")
    private int kind;
    @Schema(name = "permissions")
    private List<PermissionDto> permissions;
}
