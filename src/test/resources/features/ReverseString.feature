Feature: String Reverse

  @string-reverse
  Scenario Outline:
    When user enters a string "<input-string>"
    Then output should be a reverse string "<output-string>"
    Examples:
      | input-string            | output-string           |
      | hope you are doing well | llew gniod era uoy epoh |
      | test                    | tset                    |
      | a                       | a                       |