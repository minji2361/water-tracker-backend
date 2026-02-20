package com.yeoul.waterapp.controller;

import com.yeoul.waterapp.dto.CupPresetsRequest;
import com.yeoul.waterapp.dto.CupPresetsResponse;
import com.yeoul.waterapp.service.CupPresetService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class CupPresetController {

    private final CupPresetService cupPresetService;

    public CupPresetController(CupPresetService cupPresetService) {
        this.cupPresetService = cupPresetService;
    }

    @PutMapping("/{id}/cup-presets")
    public CupPresetsResponse updatePresets(
            @PathVariable("id") Long id,
            @RequestBody CupPresetsRequest request) {
        return cupPresetService.updatePresets(id, request);
    }

    @GetMapping("/{id}/cup-presets")
    public CupPresetsResponse getPresets(@PathVariable("id") Long id) {
        return cupPresetService.getPresets(id);
    }
}