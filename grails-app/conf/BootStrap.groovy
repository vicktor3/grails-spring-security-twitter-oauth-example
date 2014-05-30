import oauthapp.User
import oauthapp.Role
import oauthapp.UserRole

class BootStrap {

    def init = { servletContext ->
        
        def adminRole = Role.findOrSaveWhere(authority: "ROLE_ADMIN")
        def userRole = Role.findOrSaveWhere(authority: "ROLE_USER")

        if(!User.findByUsername("admin")) {
            def admin = User.findOrSaveWhere(username: "admin", password:
            "password", enabled: true, accountExpired: false, accountLocked: false,
            passwordEnabled: true, passwordExpired: false)

            if(!admin.authorities.contains(adminRole)) {
                //todo: will throw an Exception if the user already exists
                UserRole.create(admin, adminRole, true)
            }
        } 

        if(!User.findByUsername("guest")) {
            def guest = User.findOrSaveWhere(username: "guest", password: "password",
                    enabled: true, accountExpired: false, accountLocked: false,
                    passwordEnabled: true, passwordExpired: false)
            if(!guest.authorities.contains(userRole)) {
                UserRole.create(guest, userRole, true)
            }
        }

    }
    def destroy = {
    }
}
