def generate_permutations(s):
    result = []
    
    def backtrack(start):
        if start == len(s) - 1:
            result.append(''.join(s))
            return
        
        for i in range(start, len(s)):
            # Поменять местами текущий элемент со стартовым
            s[start], s[i] = s[i], s[start]
            # Рекурсивно генерировать перестановки для оставшейся части
            backtrack(start + 1)
            # Backtrack - вернуть обратно
            s[start], s[i] = s[i], s[start]
    
    # Преобразуем строку в список символов для мутаций
    chars = list(s)
    backtrack(0)
    return result

# Пример использования
if __name__ == "__main__":
    input_str = "abc"
    permutations = generate_permutations(input_str)
    print(f"Перестановки строки \"{input_str}\":")
    for perm in permutations:
        print(perm)