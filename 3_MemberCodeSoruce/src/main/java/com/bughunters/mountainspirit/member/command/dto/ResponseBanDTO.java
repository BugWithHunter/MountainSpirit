package com.bughunters.mountainspirit.member.command.dto;


import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ResponseBanDTO {
    private Long id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long userId;
    private Long adminId;
}
