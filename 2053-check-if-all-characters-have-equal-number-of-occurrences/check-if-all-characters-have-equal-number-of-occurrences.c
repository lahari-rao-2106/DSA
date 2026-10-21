
bool areOccurrencesEqual(char* s) {
    int count[26] = {0};
    char *p = s;
    while (*p != '\0') {
        count[*p - 'a']++;
        p++;
    }
    int freq = 0;
    for (int i = 0; i < 26; i++) {
        if (count[i] > 0) {
            if (freq == 0) freq = count[i];
            else if (count[i] != freq) return false;
        }
    }
    return true;
}
