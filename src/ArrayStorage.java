/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    private int size = 0;

    void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    void save(Resume r) {
        if (size < storage.length) {
            storage[size] = r;
            size++;
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].toString())) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        int deletedPosition = -1;
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].toString())) {
                deletedPosition = i;
                size--;
                break;
            }
        }
        for (int i = deletedPosition; i < size; i++) {
            if (i < storage.length - 1) {
                storage[i] = storage[i + 1];
            } else {
                storage[i] = null;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] allResume = new Resume[size];
        if (size > 0) {
            System.arraycopy(storage, 0, allResume, 0, size);
        }
        return allResume;
    }

    int size() {
        return size;
    }
}