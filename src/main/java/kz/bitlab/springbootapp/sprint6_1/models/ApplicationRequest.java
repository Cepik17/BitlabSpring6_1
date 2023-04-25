package kz.bitlab.springbootapp.sprint6_1.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "app_requests")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "username")
    private String userName;
//    @Column(name = "coursename")
//    private String courseName;
    @Column(name = "commentary")
    private String commentary;
    @Column(name = "phone")
    private String phone;
    @Column(name = "handled")
    private boolean handled; //обработано или нет
    @ManyToOne
    private Course course;
}
