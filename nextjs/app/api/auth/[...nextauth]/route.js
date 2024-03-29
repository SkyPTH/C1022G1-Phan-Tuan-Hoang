import NextAuth from 'next-auth';
import GoogleProvider from 'next-auth/providers/google';
import  {connectToDB} from "../../../../utils/database";

console.log(
    {
        clientId: process.env.GOOGLE_ID,
        clientSecret: process.env.GOOGLE_CLIENT_SECRET
    }
)
const handler = NextAuth({
    providers: [
        GoogleProvider({
            clientId: process.env.GOOGLE_ID,
            clientSecret: process.env.GOOGLE_CLIENT_SECRET
        })
    ],
    async session({ session }) {
    },
    async signIn({ profile }){
        try {
            await connectToDB()
            //check user exist

            //if not create new
            return true
        }
        catch (e) {
            console.log(e)
        }
    }
})
export { handler as GET, handler as POST };