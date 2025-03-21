package com.ats.ats_keyword_optimizer.controller;

import com.ats.ats_keyword_optimizer.model.ComparisonResult;
import com.ats.ats_keyword_optimizer.service.KeywordService;
import com.ats.ats_keyword_optimizer.util.ResumeParserUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.io.File;

@RestController
@RequestMapping("/api/keywords")
public class KeywordController {

    @Autowired
    private KeywordService keywordService;

    @Autowired
    private ResumeParserUtil resumeParserUtil;

    @PostMapping("/parseResume")
    public ResponseEntity<String> parseResumeFile(@RequestParam("file") MultipartFile file) throws Exception {
    File resumeFile = convertMultiPartToFile(file);
        String resumeText = resumeParserUtil.parseResume(resumeFile);
        return ResponseEntity.ok(resumeText);
        }
    
        private File convertMultiPartToFile(MultipartFile file) throws IOException {
        File convFile = new File(System.getProperty("java.io.tmpdir") + "/" + file.getOriginalFilename());
        file.transferTo(convFile);
        return convFile;
        }

    
        @PostMapping("/extract")
    public ResponseEntity<Set<String>> extractKeywords(@RequestBody String jdText) {
        Set<String> keywords = keywordService.extractKeywords(jdText);
        return ResponseEntity.ok(keywords);
    }

    @PostMapping("/compare")
    public ResponseEntity<ComparisonResult> compareResumeToJD(@RequestBody Map<String, String> request) {
        Set<String> jdKeywords = keywordService.extractKeywords(request.get("jobDescription"));
        Set<String> resumeKeywords = keywordService.extractKeywords(request.get("resumeText"));

        ComparisonResult result = keywordService.compare(resumeKeywords, jdKeywords);
        return ResponseEntity.ok(result);
    }
}
