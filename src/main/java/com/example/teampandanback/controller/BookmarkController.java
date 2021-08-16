package com.example.teampandanback.controller;

import com.example.teampandanback.OAuth2.UserDetailsImpl;
import com.example.teampandanback.dto.note.response.NoteSearchInBookmarkResponseDto;
import com.example.teampandanback.service.BookmarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class BookmarkController {

    private final BookmarkService bookmarkService;

    //북마크 함
    @PostMapping("/api/notes/{noteId}/bookmark")
    public void bookmarkNote(@PathVariable Long noteId, @AuthenticationPrincipal UserDetailsImpl userDetails){
        bookmarkService.bookmarkNote(noteId,userDetails.getUser());
    }

    //북마크 해제
    @PostMapping("/api/notes/{noteId}/unbookmark")
    public void unBookmarkNote(@PathVariable Long noteId, @AuthenticationPrincipal UserDetailsImpl userDetails){
        bookmarkService.unBookmarkNote(noteId,userDetails.getUser());
    }

    // 북마크한 노트들 중에서 노트 제목 검색
    @GetMapping("/api/notes/search/bookmarks")
    public NoteSearchInBookmarkResponseDto searchNoteInBookmark(@AuthenticationPrincipal UserDetailsImpl userDetails, @RequestParam("keyword") String rawKeyword){
        return bookmarkService.searchNoteInBookmarks(userDetails.getUser(), rawKeyword);
    }
}
