package edu.phoenix;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TranslatorTest {
  @Test
  void shouldTranslateMessage() {
    Map<String, String> templateText = Map.of(
        "en", "Dear Customer! Your card ${card.number} successfully topped up to ${payment.sum} ${payment.currency}!",
        "ru", "Уважаемый клиент! Ваша карта ${card.number} успешно пополнена на ${payment.sum} ${payment.currency}!"
    );
    Map<String, String> variables = Map.of(
        "card.number", "2345 6542 8721 4562",
        "payment.sum", "50",
        "payment.currency", "€"
    );

    Map<String, String> expected = Map.of(
        "en", "Dear Customer! Your card 2345 6542 8721 4562 successfully topped up to 50 €!",
        "ru", "Уважаемый клиент! Ваша карта 2345 6542 8721 4562 успешно пополнена на 50 €!"
    );

    Map<String, String> actual = Translator.translate(templateText, variables);

    assertEquals(expected, actual);
  }

}