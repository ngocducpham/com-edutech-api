package com.edutech.api.storage.model;

//import com.landingis.api.storage.projection.impl.GroupIdNamePermissionsImpl;
//import com.landingis.api.storage.projection.impl.PermissionIdNameActionImpl;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@NamedNativeQuery(
//        name = "GroupPermission",
//        query = "SELECT g.id AS group_id, g.name AS group_name, p.id AS permission_id,p.name AS permission_name,p.action AS permission_action FROM landingis_group g INNER JOIN landingis_permission_group pg ON g.id = pg.group_id INNER JOIN landingis_permission p ON pg.permission_id = p.id WHERE g.name = :name GROUP BY g.id, g.name, p.id, p.name, p.action",
////        query="",
//        resultSetMapping = "GroupPermissionMapping"
//)
//
//@SqlResultSetMapping(
//        name = "GroupPermissionMapping",
//        classes = {
//                @ConstructorResult(
//                        targetClass = GroupIdNamePermissionsImpl.class,
//                        columns = {
//                                @ColumnResult(name = "group_id", type = Long.class),
//                                @ColumnResult(name = "group_name", type = String.class),
//                        }
//                ),
//                @ConstructorResult(
//                        targetClass = PermissionIdNameActionImpl.class,
//                        columns = {
//                                @ColumnResult(name = "permission_id", type = Long.class),
//                                @ColumnResult(name = "permission_name", type = String.class),
//                                @ColumnResult(name = "permission_action", type = String.class)
//                        }
//                )
//        }
//)

@Entity
@Table(name = TablePrefix.PREFIX_TABLE + "group")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Group extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name", unique = true)
    private String name;
    @Column(name = "description", length = 1000)
    private String description;
    @Column(name = "kind")
    private int kind;

    @Column(name = "is_super_admin")
    private Boolean isSuperAdmin = false;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinTable(name = TablePrefix.PREFIX_TABLE + "permission_group",
            joinColumns = @JoinColumn(name = "group_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id",
                    referencedColumnName = "id"))
    private List<Permission> permissions = new ArrayList<>();

}
