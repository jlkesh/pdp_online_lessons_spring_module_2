package uz.pdp.mapstruct.person;

import lombok.*;

@ToString
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@Builder
public class PassportDTO {
    private String serial;
    private String number;
}
