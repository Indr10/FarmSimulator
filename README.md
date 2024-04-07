The spawn rate of Weed is set to 20% per tick throughout the field in a soil instance. 
i.e. there is a 20% chance that a weed spawns in one of the instances of soil in the field.
This change has been made to match the sample out provided, even though the specs states that it should be 20% per soil instance in a field.

### New Functionality

**Market**
The user can choose what items to buy at the market. The items include:
- Clear Weed
- Harvest All
- Magic Serum
The user can also exit the market without buying anything. This doesn't trigger the tick function, meaning the field doesn't age if they don't purchase anything in the market. The field will age, however, if the user chooses to buy an item in the market.

### Shop Item Functionalities

**Clear Weed**
Clears all weed from the field in Farm.

**Harvest All**
Harvests all items in the field that are mature and adds up the total value of the harvest.

**Magic Serum**
- Increases the value of all crops by 1
- Decreases the death age of all crops by 1
- Decreases the maturation age of all crops by 1
