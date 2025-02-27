package org.example.pulseappapi.core.user.models;

import jakarta.persistence.*;
import lombok.Data;
import org.example.pulseappapi.authentication.enums.BloodType;
import org.example.pulseappapi.authentication.enums.GenderType;
import org.example.pulseappapi.authentication.enums.UserRole;
import org.example.pulseappapi.donation.model.Appointment;
import org.example.pulseappapi.donation.model.Donation;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password_hash", nullable = false)
    private String password;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "birth_date")
    private LocalDateTime birthDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private GenderType gender;

    @Enumerated(EnumType.STRING)
    @Column(name = "blood_type")
    private BloodType bloodType;

    @Column(name = "last_donation_date")
    private LocalDateTime lastDonationDate;

    @Column(name = "user_banner")
    private String userBanner;

    @Column(name = "user_profile_picture" )
    private String userProfilePicture;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Column
    @OneToMany(mappedBy = "donor")
    private List<Donation> donations;

    @Column
    @OneToMany(mappedBy = "donor")
    private List<Appointment> appointments;

    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == UserRole.ADMIN) {
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        }
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getPassword() {
        return this.password;
    }
}
