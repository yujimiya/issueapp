package in.techcamp.issueapp;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class IssueController {

    private final IssueRepository issueRepository;

    @GetMapping("/issueForm")
    public String showIssueForm(@ModelAttribute("issueForm") IssueForm form){
        return "issueForm";
    }

    @PostMapping("/issues")
    public String createIssue(IssueForm issueForm){
        issueRepository.insert(issueForm.getTitle(), issueForm.getContent(), issueForm.getPeriod(), issueForm.getImportance());
        return "redirect:/";
    }
}
