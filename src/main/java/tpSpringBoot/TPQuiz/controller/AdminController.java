package tpSpringBoot.TPQuiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tpSpringBoot.TPQuiz.model.Admin;
import tpSpringBoot.TPQuiz.model.User;
import tpSpringBoot.TPQuiz.repository.AdminRepository;
import tpSpringBoot.TPQuiz.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

    // @Autowired
    // private AdminRepository adminRepository;

    @Autowired
    private AdminService adminService;

    // public AdminController(AdminRepository adminRepository){
    //     this.adminRepository=adminRepository;
    // }

    //  @PostMapping("/connexion")
    // public ResponseEntity<String> seConnecter(@RequestBody Admin admin) {
    //     String nom = admin.getNom();

    //     String passwords = admin.getMdp();

    //     Admin a = adminRepository.findAdminByName(nom);

    //     if (a != null && a.getMdp().equals(passwords)) {
    //         return new ResponseEntity<>("Connexion réussie !", HttpStatus.OK);

    //     } else {
    //         return new ResponseEntity<>("Nom d'utilisateur ou mot de passe incorrect.", HttpStatus.UNAUTHORIZED);
    //     }
    // }


     @PostMapping("add")
    public ResponseEntity<String> addAdmin(@RequestBody Admin admin){
        return adminService.addAdmin(admin);
    }

    //Liste
    @GetMapping("all")
    public ResponseEntity<List<Admin>>getAllAdmin(){
        return adminService.getAllAdmin();
    }
    
}
