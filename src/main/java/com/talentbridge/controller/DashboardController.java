package com.talentbridge.controller;
import com.talentbridge.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(
    name = "Dashboard APIs",
    description = "Analytics and statistics"
)
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @Operation(summary = "Get dashboard statistics")
    @GetMapping("/dashboard/stats")
    public Map<String, Long> getStats() {
        return dashboardService.getStats();
    }
}
