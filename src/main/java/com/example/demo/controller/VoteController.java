package com.example.demo.controller;

import com.example.demo.domain.VoteType;
import com.example.demo.service.VoteService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class VoteController {

    private final VoteService voteService;

    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @GetMapping("/vote")
    public String votePage() {
        return "vote";
    }

    @PostMapping("/vote")
    public String vote(@RequestParam VoteType type,
                       HttpServletRequest request) throws IOException {

        String ip = request.getRemoteAddr();
        voteService.vote(type, ip);

        return "redirect:/result";
    }

    @GetMapping("/result")
    public String result(Model model) {
        model.addAttribute("result", voteService.getResult());
        return "result";
    }
}
