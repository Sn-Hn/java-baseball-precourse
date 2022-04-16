package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ComputerNumber {
  private static final int MAX_NUMBER_LENGTH = 3;
  private static final int START_NUMBER = 1;
  private static final int END_NUMBER = 9;

  public List<Integer> createNumber() {
    Set<Integer> computerNumbers = new LinkedHashSet<>();
    while (computerNumbers.size() < MAX_NUMBER_LENGTH) {
      int pickNumber = pickNumber();
      validateNumber(pickNumber);
      computerNumbers.add(pickNumber);
    }

    return new ArrayList<>(computerNumbers);
  }

  private int pickNumber() {
    return Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
  }

  private static void validateNumber(int number) {
    if (number < START_NUMBER || number > END_NUMBER) {
      throw new IllegalArgumentException("1에서 9까지의 숫자만 입력할 수 있습니다.");
    }
  }
}
