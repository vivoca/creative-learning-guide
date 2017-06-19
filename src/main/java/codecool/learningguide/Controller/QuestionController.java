package codecool.learningguide.Controller;

import codecool.learningguide.service.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QuestionController {

    @Autowired
    TranslationService translationService;

    @RequestMapping("/hello")
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        return "hello";
    }

    @RequestMapping(value = "/getAllWords", method = RequestMethod.GET)
    public String getAllEmployees(Model model) {
        model.addAttribute("translations", translationService.getAllTranslation());
        return "getAllWords";
    }
}
