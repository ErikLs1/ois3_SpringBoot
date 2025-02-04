package com.ois3.security.model;

import lombok.Getter;

import java.util.Set;

@Getter
public enum Role {
    STUDENT(Set.of(Permission.STUDENT_READ)),
    TEACHER(Set.of(Permission.TEACHER_READ, Permission.TEACHER_WRITE)),
    ADMIN(Set.of(Permission.ADMIN_READ, Permission.ADMIN_WRITE, Permission.ADMIN_DELETE));

    private final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

}
