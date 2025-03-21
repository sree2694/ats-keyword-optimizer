package com.ats.ats_keyword_optimizer.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class ComparisonResult {
    private Set<String> matchedKeywords;
    private Set<String> missingKeywords;
}

