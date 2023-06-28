package com.company.oop.cosmetics.core;

import com.company.oop.cosmetics.commands.*;
import com.company.oop.cosmetics.core.contracts.CommandFactory;
import com.company.oop.cosmetics.core.contracts.ProductRepository;
import com.company.oop.cosmetics.commands.contracts.Command;

public class CommandFactoryImpl implements CommandFactory {

    @Override
    public Command createCommandFromCommandName(String commandTypeValue, ProductRepository productRepository) {
        if (commandTypeValue == null || commandTypeValue.isEmpty()) {
            throw new IllegalArgumentException("Command type is missing.");
        }

        CommandType commandType;
        try {
            commandType = CommandType.valueOf(commandTypeValue.toUpperCase());
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException(String.format("%s is not supported.", e.getMessage()));
        }

        switch (commandType) {
            case CREATECATEGORY:
                return new CreateCategoryCommand(productRepository);
            case CREATEPRODUCT:
                return new CreateProductCommand(productRepository);
            case ADDPRODUCTTOCATEGORY:
                return new AddProductToCategoryCommand(productRepository);
            case SHOWCATEGORY:
                return new ShowCategoryCommand(productRepository);
            default:
                throw new IllegalArgumentException("Invalid command type.");
        }
    }

}
