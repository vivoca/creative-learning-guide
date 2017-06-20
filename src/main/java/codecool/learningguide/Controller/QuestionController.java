package codecool.learningguide.Controller;

import codecool.learningguide.model.Translation;
import codecool.learningguide.service.ExerciseService;
import codecool.learningguide.service.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class QuestionController {

    @Autowired
    TranslationService translationService;


    @RequestMapping(value = "/getAllWords", method = RequestMethod.GET)
    public String getAllTranslation(Model model) {
        model.addAttribute("translations", translationService.getAllTranslation());
        return "getAllWords";
    }
}
