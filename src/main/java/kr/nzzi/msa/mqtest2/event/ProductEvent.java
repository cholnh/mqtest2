package kr.nzzi.msa.mqtest2.event;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Getter
@ToString
public class ProductEvent {
    private String name;
    private int price;
}
