//
//  ViewController.m
//  AOC1 Project3
//
//  Created by Joel Betterly on 7/16/12.
//  Copyright (c) 2012 Full Sail. All rights reserved.
//

#import "ViewController.h"

@interface ViewController ()

@end

@implementation ViewController

- (void)viewDidLoad
{
    [super viewDidLoad];
	// Do any additional setup after loading the view, typically from a nib.
}

- (void)viewDidAppear:(BOOL)animated{
    
//1. Create a function called Add.  This function will take two int values and return the result of an addition between them.
    
    int addFunc = [self firstNum:2 secondNum:3];
    NSNumber *combinedResult = [[NSNumber alloc] initWithInt:addFunc];  //Step 6 - 8
    NSString *stringNum = [NSString stringWithFormat:@"The number is "]; 
    NSString *convertToString = [combinedResult stringValue];
    NSString *convertedString = [self part1:stringNum part2:convertToString]; //part1, part2 variables are pulled from append function
    [self displayAlertWithString:convertedString]; //displays the alert onscreen. Uses the append function to combine the result text to display with the values that were combined.

//2. Create a function called compare that takes two NSIntegers values.  Return the true or false are ==.    
 
    NSInteger numOne = 5;
    NSInteger numTwo = 5;
    bool compare = [self compareOne:numOne compareTwo:numTwo];
    
    if (compare == true) {
        [self displayAlertWithString:[NSString stringWithFormat:@"Integer one is: %i and Integer two is: %i.  They are equal.",numOne, numTwo]];  //Step 9
    }else {
        [self displayAlertWithString:[NSString stringWithFormat:@"Integer one is: %i and Integer two is: %i.  They are NOT equal.",numOne, numTwo]];
    }


}

// //////////////////////
//1. The Add Function //
// ////////////////////

-(int)firstNum:(int)num1 secondNum:(int)num2{
    return num1 + num2; // we added the two int's together and now return them.
}

// ///////////////////////////
//2. The Compare Function. //
// /////////////////////////

-(bool)compareOne:(NSInteger)numOne compareTwo:(NSInteger)numTwo{
    
    if (numOne == numTwo) {
        return true;
    } else {
        return false;
    }
}

// //////////////////////////
//3. The Append Function. //
// ////////////////////////
-(NSString *)part1:(NSString *)string1 part2:(NSString *)string2{
    NSMutableString *part1String = [NSMutableString stringWithString:string1];
    NSString *newString = [part1String stringByAppendingString:string2];
    return newString;
}

// //////////////////////////////////////
//5. DisplayAlertWithString Function. //
// ////////////////////////////////////
// Create the displayAlertWithString Function
// Wendy shows how to write this function in video 34.3_UIAlertIndicator.

-(void)displayAlertWithString:(NSString *)string{
    
    UIAlertView *alertView = [[UIAlertView alloc] initWithTitle:@"Alert" message:string delegate:nil cancelButtonTitle:@"Okay" otherButtonTitles:nil, nil];
    if (alertView != nil){
        
        [alertView show];
    }
    
}


- (void)viewDidUnload
{
    [super viewDidUnload];
    // Release any retained subviews of the main view.
}

- (BOOL)shouldAutorotateToInterfaceOrientation:(UIInterfaceOrientation)interfaceOrientation
{
    if ([[UIDevice currentDevice] userInterfaceIdiom] == UIUserInterfaceIdiomPhone) {
        return (interfaceOrientation != UIInterfaceOrientationPortraitUpsideDown);
    } else {
        return YES;
    }
}

@end
