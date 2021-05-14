##
## IUT Nancy-Charlemagne, 2021
## Projet :
##    GameOfLife
## Author :
##    Erin      Bernardoni
##    Antoine   Orion
##	  Valentine INGARDIN
##    Maroua 	MELKI
## File description :
##    Compile and execute GeomPaint project
##

NAME		:= GeomPain
JC 			:= javac
EXEC		:= java
FILE_TYPE	:= java
OBJ_TYPE	:= class

OUTPUT_DIR	:= .
SRC_DIR 	:= src
OBJ_DIR		:= obj
# LIB_DIR		:= lib

SRC			:=$(wildcard $(SRC_DIR)/*.$(FILE_TYPE))
OBJ			:= $(SRC:$(SRC_DIR)/%.$(FILE_TYPE)=$(OBJ_DIR)/%.$(OBJ_TYPE))

LFLAGS		:= $(LIB_DIR)/$(PICOLIB)
CFLAGS		:= -cp $(SRC_DIR)
# CFLAGS		:= -Xlint:deprecation -cp $(SRC_DIR)
EXEFLAGS	:= -cp $(OBJ_DIR)

all		: compile

compile	: $(OBJ)
# 	$(EXEC) $(EXEFLAGS):$(LFLAGS) $(NAME)


$(OBJ_DIR)/%.$(OBJ_TYPE) : $(SRC_DIR)/%.$(FILE_TYPE)
	$(JC) $(CFLAGS):$(LFLAGS) -d $(OUTPUT_DIR)/$(shell dirname $@) $^

clean	:
	rm -f $(OBJ_DIR)/*.$(OBJ_TYPE)

fclean	: clean
	rmdir $(OBJ_DIR)

re		: fclean all

.PHONY	: all compile clean fclean re lib

# verbose mode. use as 
# 	$ make vrb=1 
$(vrb).SILENT: