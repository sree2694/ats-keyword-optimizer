package com.ats.ats_keyword_optimizer.service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.ats.ats_keyword_optimizer.model.ComparisonResult;

@Service
public class KeywordService {

    public Set<String> extractKeywords(String text) {
        return Arrays.stream(text.split("\\W+"))
                     .filter(word -> word.length() > 3)
                     .map(String::toLowerCase)
                     .collect(Collectors.toSet());
    }

    public ComparisonResult compare(Set<String> resumeWords, Set<String> jdWords) {
        Set<String> matched = resumeWords.stream()
                                         .filter(jdWords::contains)
                                         .collect(Collectors.toSet());

        Set<String> missing = jdWords.stream()
                                     .filter(word -> !resumeWords.contains(word))
                                     .collect(Collectors.toSet());

        return new ComparisonResult(matched, missing);
    }
}

