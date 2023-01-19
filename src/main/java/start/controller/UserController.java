package start.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import start.model.User;
import start.service.UserService;
import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("") // вывод всех пользователей
    public String getIndex (Model model) {
        model.addAttribute("index", userService.index());
        return "index";
    }

    @GetMapping("/{id}") // вывод пользователя по ID
    public String getOneUserId (@PathVariable("id") Integer id, Model model) {
        model.addAttribute("user", userService.getUserId(id));
        return "oneuser";
    }

    // Добавление юзера
    @GetMapping("/new") // возвращает форму для создания нового человека
    public String getNewUser(Model model) { // передеаем объект, с которым будет рабоать Шаблон Таймлиф
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping()  // принимает пост запрос после отправки формы и ложит в БД, после редирект на redirect:/users
    public String getCreate (@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "new";
        }
        userService.saveUser(user);
        return "redirect:users";
    }
    // Добавление юзера

    // Update user
   @GetMapping("/{id}/edit") // Редактируем человека - переходим на формe куда подтягиваем нашего юзера по ID
    public String getEdit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getUserId(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String getUpdate (@ModelAttribute("user") @Valid User user, BindingResult bindingResult, @PathVariable ("id") int  id) {
        System.out.println("!!!");
       if (bindingResult.hasErrors()) {
          return  "edit";
        }
        userService.updateUser(id, user);
        return "redirect:/users";
    }
    // Update user

    // Delete User
    @DeleteMapping("/{id}")
    public String getDelete (@PathVariable ("id") int  id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
    // Delete User







}
