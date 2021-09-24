package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */

/*     Выберите в классе java.util.Arrays подходящие методы для реализации
        1. clear()
        2. getAll()
*/

public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(String prevUuid, String newUuid) {
        int indexOfResumeByUuid = getIndex(prevUuid);
        int indexOfResumeByNewUuid = getIndex(newUuid);
        if (indexOfResumeByUuid == -1) {
            System.out.println("Resume is not present");
        } else if (indexOfResumeByNewUuid != -1) {
            System.out.println("Resume with such uuid is already exist");
        } else {
            storage[indexOfResumeByUuid].setUuid(newUuid);
        }
    }

    public void save(Resume r) {
        if (getIndex(r.getUuid()) != -1) {
            System.out.println("Resume is already present");
        } else {
            if (size < storage.length) {
                storage[size] = r;
                size++;
            } else {
                System.out.println("Storage is overflown");
            }
        }
    }

    public Resume get(String uuid) {
        int indexOfResumeByUuid = getIndex(uuid);
        if (indexOfResumeByUuid == -1) {
            System.out.println("Resume is not present");
            return null;
        } else {
            return storage[indexOfResumeByUuid];
        }
    }

    public void delete(String uuid) {
        int indexOfResumeByUuid = getIndex(uuid);
        if (indexOfResumeByUuid == -1) {
            System.out.println("Resume is not present");
        } else {
            storage[indexOfResumeByUuid] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}