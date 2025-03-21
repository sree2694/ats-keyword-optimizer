package com.ats.ats_keyword_optimizer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.ats.ats_keyword_optimizer.model.ComparisonResult;
import com.ats.ats_keyword_optimizer.service.KeywordService;

import java.util.Set;

@Controller
public class UIKeywordController {

    @Autowired
    private KeywordService keywordService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/analyze")
    public String analyzeKeywords(@RequestParam("jobDescription") String jd,
                                  @RequestParam("resumeText") String resume,
                                  Model model) {
        Set<String> jdKeywords = keywordService.extractKeywords(jd);
        Set<String> resumeKeywords = keywordService.extractKeywords(resume);

        ComparisonResult result = keywordService.compare(resumeKeywords, jdKeywords);

        model.addAttribute("matched", result.getMatchedKeywords());
        model.addAttribute("missing", result.getMissingKeywords());
        return "result";
    }
}

