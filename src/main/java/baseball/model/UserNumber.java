package baseball.model;

import java.util.*;
import java.util.regex.Pattern;

public class UserNumber implements Number {
  private static final int MAX_NUMBER_LENGTH = 3;
  private static final int START_INDEX = 0;
  private final Pattern numberPattern = Pattern.compile("^[1-9]*$");

  private String inputNumber;

  public UserNumber(String inputNumber) {
    this.inputNumber = inputNumber;
    validate();
  }

  @Override
  public List<Integer> createNumbers() {
    Set<Integer> userNumbers = new LinkedHashSet<>();
    for (int i = START_INDEX; i < MAX_NUMBER_LENGTH; i++) {
      userNumbers.add(Character.getNumericValue(inputNumber.charAt(i)));
    }

    return new ArrayList<>(userNumbers);
  }

  private void validate() {
    validateEscape(inputNumber);
    validateDigit(inputNumber);
    validateDuplication(inputNumber);
  }

  private void validateEscape(String inputNumber) {
    if (!numberPattern.matcher(inputNumber).find()) {
      throw new IllegalArgumentException("1에서 9까지의 숫자만 입력할 수 있습니다.");
    }
  }

  private void validateDigit(String inputNumber) {
    if (inputNumber.length() != MAX_NUMBER_LENGTH) {
      throw new IllegalArgumentException("세 자리의 숫자만 입력할 수 있습니다.");
    }
  }

  private void validateDuplication(String inputNumber) {
    Set<String> convertInputNumber = new LinkedHashSet<>(Arrays.asList(inputNumber.split("")));
    if (convertInputNumber.size() != MAX_NUMBER_LENGTH) {
      throw new IllegalArgumentException("중복되지 않은 숫자만 입력할 수 있습니다.");
    }
  }
}
