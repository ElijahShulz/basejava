/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        int size = size();
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
    }

    void save(Resume r) {
        storage[size()] = r;
    }

    Resume get(String uuid) {
        for (int i = 0; i < size(); i++) {
            if (uuid.equals(storage[i].toString())) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        int deletedPosition = Integer.MIN_VALUE;
        for (int i = 0; i < size(); i++) {
            if (uuid.equals(storage[i].toString())) {
                deletedPosition = i;
            }
            if (deletedPosition >= 0 && deletedPosition < storage.length - 1) {
                storage[i] = storage[i + 1];
            } else if (deletedPosition == storage.length - 1) {
                storage[i] = null;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] storageToReturn = new Resume[size()];
        for (int i = 0; i < size(); i++) {
            storageToReturn[i] = storage[i];
        }
        return storageToReturn;
    }

    int size() {
        int i = 0;
        while (storage[i] != null) {
            i++;
        }
        return i;
    }
}
