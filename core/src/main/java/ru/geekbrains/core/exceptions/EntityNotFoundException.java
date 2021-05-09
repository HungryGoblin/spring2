package ru.geekbrains.core.exceptions;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException (String message) {
        super(message);
    }

    public EntityNotFoundException (Class entityClass) {
        super(String.format("Entity %s does not exist", entityClass.getSimpleName()));
    }

    public EntityNotFoundException (Class entityClass, long entityId) {
        super(String.format("Entity %s (%d) does not exist", entityClass.getSimpleName(), entityId));
    }

}
