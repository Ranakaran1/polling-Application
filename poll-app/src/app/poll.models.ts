export interface OptionVote {
    OptionIndex: string;
    votes: number;
}
export interface Poll {
    id: number;
    question: string;
    options: OptionVote[];

}
